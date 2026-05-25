class Twitter {

    class User {
        Set<Integer> follows;
        List<Integer> tweets;
        
        public User() {
            follows = new HashSet<>();
            tweets = new ArrayList<>();
        }
    }

    User[] users;
    int timer = 0;
    Map<Integer, Integer> tweetTime = new HashMap<>();

    public Twitter() {
        users = new User[101];
        for(int i=1; i < 101; i++) {
            users[i] = new User();
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        users[userId].tweets.add(tweetId);
        tweetTime.put(tweetId, timer++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> tweetTime.get(b) - tweetTime.get(a));
        addTweetsToHeap(userId, maxHeap);
        for(int followeeId: users[userId].follows) {
            if (followeeId != userId) addTweetsToHeap(followeeId, maxHeap);
        }
        List<Integer> result = new ArrayList<>();
        while(maxHeap.size() > 0 && result.size() < 10) {
            result.add(maxHeap.poll());
        }

        return result;
    }

    private void addTweetsToHeap(int userId, PriorityQueue<Integer> maxHeap) {
        for(int tweetId : users[userId].tweets) {
            maxHeap.add(tweetId);
        }
    }
    
    public void follow(int followerId, int followeeId) {
        users[followerId].follows.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        users[followerId].follows.remove(followeeId);
    }
}