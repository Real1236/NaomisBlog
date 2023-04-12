package com.arthur.blog.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "blog-posts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "blog")
    private String blog;

    @ManyToMany
    @JoinTable(name = "likes",
                joinColumns = @JoinColumn(name = "blogpost_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserEntity> likes;

    public BlogPost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Set<UserEntity> getLikes() {
        return likes;
    }

    public void setLikes(Set<UserEntity> likes) {
        this.likes = likes;
    }

    public int getNumOfLikes() {
        return this.likes.size();
    }

    public List<Integer> getLikedUserIds() {
        List<Integer> likedUserIds = new ArrayList<>();
        for (UserEntity user : this.likes) {
            likedUserIds.add(user.getId());
        }
        return likedUserIds;
    }

    @Override
    public String toString() {
        String res;
        if (image == null) {
            res = "BlogPost{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", date=" + date +
                    ", blog='" + blog + '\'' +
                    '}';
        } else {
            res = "BlogPost{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", date=" + date +
                    ", image=" + Arrays.toString(Arrays.copyOfRange(image, 0, 5)) +
                    ", blog='" + blog + '\'' +
                    '}';
        }
        return res;
    }
}
