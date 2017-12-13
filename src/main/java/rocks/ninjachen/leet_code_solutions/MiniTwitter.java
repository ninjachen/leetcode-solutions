package rocks.ninjachen.leet_code_solutions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * http://www.lintcode.com/zh-cn/problem/mini-twitter/
 * Created by ninja on 3/17/16.
 */
public class MiniTwitter {
    private boolean debug = true;

    public static void main(String[] arg){
//        testCase1();
//        testCase2();
        testCase3();
    }

    private static void testCase3() {
        MiniTwitter t = new MiniTwitter();
        t.postTweet(1, "LintCode is Good!!!");//1
        t.getNewsFeed(1);
        t.getTimeline(1);
        t.follow(2, 1);
        t.follow(2, 3);
        t.postTweet(3, "LintCode is Cool!!!");//2
        t.postTweet(3, "How to do A + B problem?");//3
        t.postTweet(3, "I have accepted A + B problem.");//4
        t.postTweet(3, "I favorite A + B problem.");//5
        t.postTweet(1, "I favorite A + B problem too.");//6
        t.postTweet(2, "Nani?");//7
        t.postTweet(2, "I want to solve this problem now.");//8
        t.postTweet(3, "I want to solve this problem now.");//9
        t.postTweet(3, "The problem is so easy.");//10
        t.postTweet(1, "hehe.");//11
        t.postTweet(2, "Let's to do it together.");//12
        t.postTweet(2, "haha");//13
        t.getNewsFeed(2);
        t.getTimeline(2);
        t.getNewsFeed(1);
        t.follow(1, 2);
        t.getNewsFeed(1);
        t.follow(1, 3);
        t.getNewsFeed(1);
        t.unfollow(2, 1);
        t.getNewsFeed(2);
    }

    private static void testCase1() {
        MiniTwitter t = new MiniTwitter();
        t.postTweet(1, "LintCode is Good!!!");
        t.getNewsFeed(1);
        t.getTimeline(1);
        t.follow(2, 1);
        t.getNewsFeed(2);
        t.unfollow(2, 1);
        t.getNewsFeed(2);
    }

    private static void testCase2() {
        MiniTwitter t = new MiniTwitter();
        t.postTweet(1, "LintCode is Good!!!");
        t.getNewsFeed(1);
        t.getTimeline(1);
        t.follow(2, 1);
        t.postTweet(1, "LintCode is Good!!!");
        t.getNewsFeed(2);
        t.unfollow(2, 1);
        t.getNewsFeed(2);
    }

    // <id, text>
        Map<Integer, List<Tweet>> posts = new HashMap<>();
        Map<Integer, Long> postData = new HashMap<>();
        // <id, List<followed_id>>
        Map<Integer, List<Integer>> followRelation = new HashMap();


        public MiniTwitter() {
            // initialize your data structure here.
        }

        // @param user_id an integer
        // @param tweet a string
        // return a tweet
        public Tweet postTweet(int user_id, String tweet_text) {
            //  Write your code here
            Tweet t = Tweet.create(user_id, tweet_text);
            postData.put(t.id, new Date().getTime());
            List<Tweet> l = posts.get(user_id);
            if(l == null){
                l = new ArrayList<>();
                posts.put(user_id, l);
            }
            l.add(t);
            return t;
        }

        // @param user_id an integer
        // return a list of 10 new feeds recently
        // and sort by timeline
        public List<Tweet> getNewsFeed(int user_id) {
            // Write your code here
            List<Integer> ids = followRelation.get(user_id);
            if(ids == null) ids = new ArrayList<>();
            ids.add(user_id);
            List<Tweet> tweets = new ArrayList();
            for(Integer id : ids){
                List<Tweet> ts = getTimeline(id);
                if(ts != null)
                    tweets.addAll(ts);
            }
            tweets = sort(tweets);
            if(tweets != null && tweets.size()>10){
                tweets = tweets.subList(0,10);
            }
            if(debug) System.out.println("getNewsFeed: "+tweets);
            return tweets;
        }

        public List<Tweet> sort(List<Tweet>tweets) {
            if(tweets == null || tweets.size() < 2) return tweets;

            for(int i = 0; i< tweets.size()-1; i++){
                for(int j = i; j< tweets.size()-1; j++){
                    Tweet t1 = tweets.get(j);
                    Tweet t2 = tweets.get(j+1);
                    if(postData.get(t1.id) < postData.get(t2.id)){
                        //swap
                        tweets.add(j, t2);
                        tweets.remove(j+2);
                    }
                }
            }
            return tweets;
        }

        // @param user_id an integer
        // return a list of 10 new posts recently
        // and sort by timeline
        public List<Tweet>  getTimeline(int user_id) {
            // Write your code here
            List l = posts.get(user_id);
            if(l != null && l.size() >9){
                l = l.subList(0,10);
            }
            if(debug) System.out.println("getTimeline: "+l);
            return l;
        }

        // @param from_user_id an integer
        // @param to_user_id an integer
        // from user_id follows to_user_id
        public void follow(int from_user_id, int to_user_id) {
            // Write your code here
            List<Integer> followed_id_list = followRelation.get(from_user_id);
            if(followed_id_list == null){
                followed_id_list = new ArrayList();
                followRelation.put(from_user_id, followed_id_list);
            }
            followed_id_list.add(to_user_id);
        }

        // @param from_user_id an integer
        // @param to_user_id an integer
        // from user_id unfollows to_user_id
        public void unfollow(int from_user_id, int to_user_id) {
            // Write your code here
            List<Integer> followed_id_list = followRelation.get(from_user_id);
            if(followed_id_list == null){
                return;
            }
            Iterator<Integer> iterator = followed_id_list.iterator();
            while (iterator.hasNext()){
                Integer i = iterator.next();
                if(i.equals(to_user_id)){
                    iterator.remove();
                    return;
                }
            }
        }
    public static class Tweet {
        public static int idIndex=0;
        public int id;
        public int user_id;
        public String text;
        Tweet(int user_id, String text){
            this.id = ++idIndex;
            this.user_id = user_id;
            this.text = text;
        }

        public static Tweet create(int user_id, String tweet_text) {
                // This will create a new tweet object,
                // and auto fill id
                return new Tweet(user_id, tweet_text);
            }

        @Override
        public String toString() {
//            String s = String.format("tweet: id is %d, user_id is %d, text is %s", id, user_id, text);
            String s = String.format("tweet: id is %d, user_id is %d, text is %s", id, user_id, text);
                return String.valueOf(id);
        }
    }

}
