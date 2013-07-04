package com.tid.news;

import java.util.List;

import com.sun.syndication.feed.synd.SyndContent;

public class Blog {
	
	 private int id;
	 private String title;
	 private String content;//¿¿¿???
	 
    
	public Blog(int id, String title, String content) 
    {
   	this.id = id;
       this.title = title;
       this.content = content;
    }
    
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	

}
