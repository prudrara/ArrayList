package LinkedList_Tutorial;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	
	private ArrayList<Songs> songs;
	private String name;
	private String artist;
	
	public Album(String name, String artist) {
		
		this.songs = new ArrayList<Songs>();
		this.name = name;
		this.artist = artist;
	}
	
	public boolean addSong(String title, double duration) {
		if(findSong(title) == null) {
			this.songs.add(new Songs(title, duration));
			return true;
		}
		return false;
	}
	
	
	private Songs findSong(String title) {
		for (Songs checkedSong : this.songs) {
			if(checkedSong.getTitle().equals(title)) {
				return checkedSong;
			}
		}
		return null;	
		}
	
	public boolean addToPlaylist(int trackNumber, LinkedList<Songs> playList) {
		int index = trackNumber-1;
		if((index>=0) && index <= this.songs.size()) {
			playList.add(this.songs.get(index));
			return true;
		}
		
		System.out.println("THis album doesnot have a track" + trackNumber);
		return false;
	}
	
	public boolean addToPlaylist(String title, LinkedList<Songs> playList) {
		Songs checkedSong = findSong(title);
		
		if(checkedSong != null) {
			playList.add(checkedSong);
			return true;
		}
		
		System.out.println("The Song" +title + "is not in the album");
		return false;
		
		}

}
