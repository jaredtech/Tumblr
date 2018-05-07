package cn.baililuohui.tumblr.Gson;

import java.util.List;

public class UserGson {

    /**
     * meta : {"status":200,"msg":"OK"}
     * response : {"user":{"name":"millerrjc","likes":266,"following":209,"default_post_format":"html","blogs":[{"admin":true,"ask":false,"ask_anon":false,"ask_page_title":"Ask me anything","can_send_fan_mail":true,"can_subscribe":false,"description":"","drafts":0,"facebook":"N","facebook_opengraph_enabled":"N","followed":false,"followers":5,"is_adult":true,"is_blocked_from_primary":false,"is_nsfw":true,"messages":2,"name":"millerrjc","posts":2,"primary":true,"queue":0,"reply_conditions":"3","share_likes":false,"subscribed":false,"title":"","total_posts":2,"tweet":"N","twitter_enabled":false,"twitter_send":false,"type":"public","updated":1525186024,"url":"https://millerrjc.tumblr.com/"}]}}
     */

    private MetaBean meta;
    private ResponseBean response;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class MetaBean {
        /**
         * status : 200
         * msg : OK
         */

        private int status;
        private String msg;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class ResponseBean {
        /**
         * user : {"name":"millerrjc","likes":266,"following":209,"default_post_format":"html","blogs":[{"admin":true,"ask":false,"ask_anon":false,"ask_page_title":"Ask me anything","can_send_fan_mail":true,"can_subscribe":false,"description":"制服控","drafts":0,"facebook":"N","facebook_opengraph_enabled":"N","followed":false,"followers":5,"is_adult":true,"is_blocked_from_primary":false,"is_nsfw":true,"messages":2,"name":"millerrjc","posts":2,"primary":true,"queue":0,"reply_conditions":"3","share_likes":false,"subscribed":false,"title":"制服","total_posts":2,"tweet":"N","twitter_enabled":false,"twitter_send":false,"type":"public","updated":1525186024,"url":"https://millerrjc.tumblr.com/"}]}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * name : millerrjc
             * likes : 266
             * following : 209
             * default_post_format : html
             * blogs : [{"admin":true,"ask":false,"ask_anon":false,"ask_page_title":"Ask me anything","can_send_fan_mail":true,"can_subscribe":false,"description":"制服控","drafts":0,"facebook":"N","facebook_opengraph_enabled":"N","followed":false,"followers":5,"is_adult":true,"is_blocked_from_primary":false,"is_nsfw":true,"messages":2,"name":"millerrjc","posts":2,"primary":true,"queue":0,"reply_conditions":"3","share_likes":false,"subscribed":false,"title":"制服","total_posts":2,"tweet":"N","twitter_enabled":false,"twitter_send":false,"type":"public","updated":1525186024,"url":"https://millerrjc.tumblr.com/"}]
             */

            private String name;
            private int likes;
            private int following;
            private String default_post_format;
            private List<BlogsBean> blogs;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getLikes() {
                return likes;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }

            public int getFollowing() {
                return following;
            }

            public void setFollowing(int following) {
                this.following = following;
            }

            public String getDefault_post_format() {
                return default_post_format;
            }

            public void setDefault_post_format(String default_post_format) {
                this.default_post_format = default_post_format;
            }

            public List<BlogsBean> getBlogs() {
                return blogs;
            }

            public void setBlogs(List<BlogsBean> blogs) {
                this.blogs = blogs;
            }

            public static class BlogsBean {
                /**
                 * admin : true
                 * ask : false
                 * ask_anon : false
                 * ask_page_title : Ask me anything
                 * can_send_fan_mail : true
                 * can_subscribe : false
                 * description : 制服控
                 * drafts : 0
                 * facebook : N
                 * facebook_opengraph_enabled : N
                 * followed : false
                 * followers : 5
                 * is_adult : true
                 * is_blocked_from_primary : false
                 * is_nsfw : true
                 * messages : 2
                 * name : millerrjc
                 * posts : 2
                 * primary : true
                 * queue : 0
                 * reply_conditions : 3
                 * share_likes : false
                 * subscribed : false
                 * title : 制服
                 * total_posts : 2
                 * tweet : N
                 * twitter_enabled : false
                 * twitter_send : false
                 * type : public
                 * updated : 1525186024
                 * url : https://millerrjc.tumblr.com/
                 */

                private boolean admin;
                private boolean ask;
                private boolean ask_anon;
                private String ask_page_title;
                private boolean can_send_fan_mail;
                private boolean can_subscribe;
                private String description;
                private int drafts;
                private String facebook;
                private String facebook_opengraph_enabled;
                private boolean followed;
                private int followers;
                private boolean is_adult;
                private boolean is_blocked_from_primary;
                private boolean is_nsfw;
                private int messages;
                private String name;
                private int posts;
                private boolean primary;
                private int queue;
                private String reply_conditions;
                private boolean share_likes;
                private boolean subscribed;
                private String title;
                private int total_posts;
                private String tweet;
                private boolean twitter_enabled;
                private boolean twitter_send;
                private String type;
                private int updated;
                private String url;

                public boolean isAdmin() {
                    return admin;
                }

                public void setAdmin(boolean admin) {
                    this.admin = admin;
                }

                public boolean isAsk() {
                    return ask;
                }

                public void setAsk(boolean ask) {
                    this.ask = ask;
                }

                public boolean isAsk_anon() {
                    return ask_anon;
                }

                public void setAsk_anon(boolean ask_anon) {
                    this.ask_anon = ask_anon;
                }

                public String getAsk_page_title() {
                    return ask_page_title;
                }

                public void setAsk_page_title(String ask_page_title) {
                    this.ask_page_title = ask_page_title;
                }

                public boolean isCan_send_fan_mail() {
                    return can_send_fan_mail;
                }

                public void setCan_send_fan_mail(boolean can_send_fan_mail) {
                    this.can_send_fan_mail = can_send_fan_mail;
                }

                public boolean isCan_subscribe() {
                    return can_subscribe;
                }

                public void setCan_subscribe(boolean can_subscribe) {
                    this.can_subscribe = can_subscribe;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getDrafts() {
                    return drafts;
                }

                public void setDrafts(int drafts) {
                    this.drafts = drafts;
                }

                public String getFacebook() {
                    return facebook;
                }

                public void setFacebook(String facebook) {
                    this.facebook = facebook;
                }

                public String getFacebook_opengraph_enabled() {
                    return facebook_opengraph_enabled;
                }

                public void setFacebook_opengraph_enabled(String facebook_opengraph_enabled) {
                    this.facebook_opengraph_enabled = facebook_opengraph_enabled;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }

                public int getFollowers() {
                    return followers;
                }

                public void setFollowers(int followers) {
                    this.followers = followers;
                }

                public boolean isIs_adult() {
                    return is_adult;
                }

                public void setIs_adult(boolean is_adult) {
                    this.is_adult = is_adult;
                }

                public boolean isIs_blocked_from_primary() {
                    return is_blocked_from_primary;
                }

                public void setIs_blocked_from_primary(boolean is_blocked_from_primary) {
                    this.is_blocked_from_primary = is_blocked_from_primary;
                }

                public boolean isIs_nsfw() {
                    return is_nsfw;
                }

                public void setIs_nsfw(boolean is_nsfw) {
                    this.is_nsfw = is_nsfw;
                }

                public int getMessages() {
                    return messages;
                }

                public void setMessages(int messages) {
                    this.messages = messages;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getPosts() {
                    return posts;
                }

                public void setPosts(int posts) {
                    this.posts = posts;
                }

                public boolean isPrimary() {
                    return primary;
                }

                public void setPrimary(boolean primary) {
                    this.primary = primary;
                }

                public int getQueue() {
                    return queue;
                }

                public void setQueue(int queue) {
                    this.queue = queue;
                }

                public String getReply_conditions() {
                    return reply_conditions;
                }

                public void setReply_conditions(String reply_conditions) {
                    this.reply_conditions = reply_conditions;
                }

                public boolean isShare_likes() {
                    return share_likes;
                }

                public void setShare_likes(boolean share_likes) {
                    this.share_likes = share_likes;
                }

                public boolean isSubscribed() {
                    return subscribed;
                }

                public void setSubscribed(boolean subscribed) {
                    this.subscribed = subscribed;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTotal_posts() {
                    return total_posts;
                }

                public void setTotal_posts(int total_posts) {
                    this.total_posts = total_posts;
                }

                public String getTweet() {
                    return tweet;
                }

                public void setTweet(String tweet) {
                    this.tweet = tweet;
                }

                public boolean isTwitter_enabled() {
                    return twitter_enabled;
                }

                public void setTwitter_enabled(boolean twitter_enabled) {
                    this.twitter_enabled = twitter_enabled;
                }

                public boolean isTwitter_send() {
                    return twitter_send;
                }

                public void setTwitter_send(boolean twitter_send) {
                    this.twitter_send = twitter_send;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getUpdated() {
                    return updated;
                }

                public void setUpdated(int updated) {
                    this.updated = updated;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
