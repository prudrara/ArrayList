package LinkedList_Tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Album> albums = new ArrayList<Album>();

	public static void main(String[] args) {
		
		Album album = new Album("Praneeth", "Deepank");
		album.addSong("Cheap Thrills", 4.09);
		album.addSong("Heap Thrills", 4.09);
		album.addSong("Eap Thrills", 4.09);
		album.addSong("P Thrills", 4.09);
		album.addSong("Radio Thrills", 4.09);
		album.addSong("Gaga Thrills", 4.09);
		
		albums.add(album);
		
		Album album2 = new Album("Chandu", "ROck");
		album.addSong("Rock Thrills", 4.19);
		album.addSong("Real Thrills", 4.09);
		album.addSong("Red Thrills", 4.09);
		album.addSong("Panda Thrills", 4.09);
		album.addSong("Rio Thrills", 4.09);
		album.addSong("Bhag Thrills", 4.09);
		
		albums.add(album2);
		
		LinkedList<Songs> playList = new LinkedList<Songs>();
		albums.get(0).addToPlaylist("Bhag Thrills", playList);
		albums.get(0).addToPlaylist("Speaking", playList);
		
		
		albums.get(0).addToPlaylist(0, playList);
		
		albums.get(0).addToPlaylist(1, playList);
		albums.get(0).addToPlaylist(34, playList);
		play(playList);
	}
	
	
	private static void play (LinkedList<Songs> playList) {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Songs> listIterator = playList.listIterator();
		if(playList.size() == 0) {
			System.out.println("No songs in the playlist");
			return;
		}
		else {
			System.out.println("Now Playing" + listIterator.next().toString());
		}
		
		while (!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("PlayList Complete");
				quit = true;
				break;
				
			case 1: 
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now Playing" + listIterator.next().toString());
				}
				else {
					System.out.println("We have reached the end of the playlist");
					forward = false;
				}
				break;
				
				
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now Playing" + listIterator.previous().toString());
				}
				else {
					System.out.println("We have reached the beginning of the playlist");
					forward = true;
				}
				break;
				 
			case 3: if(forward) {
				if(listIterator.hasPrevious()) {
					System.out.println("Now Playing" + listIterator.previous().toString());
					forward = false;
					
				}
				else {
					System.out.println("We are at the start of the list");
				}
			}
			else {
				if(listIterator.hasNext()) {
					System.out.println("Now Playing" + listIterator.next().toString());
					forward = true;
					
				}
				else {
					System.out.println("We are at the end of the list");
				}
				
			}
			
				break;
				
			case 4:printList(playList);
				break;
				
			case 5:
				printMenu();
				break;
				
				
			case 6:
				if(playList.size() > 0) {
					listIterator.remove();
					
					if(listIterator.hasNext()) {
						System.out.println("Now Playing" + listIterator.next().toString());
					}
					
					if(listIterator.hasPrevious()) {
						System.out.println("Now Playing" + listIterator.previous().toString());
					}
				}
				break;
			}
			
		}
		
	}
	
	   private static void printMenu() {
	        System.out.println("\nAvailable actions:\npress");
	        System.out.println("0  - to shutdown\n" +
	                           "1  - to play next song\n" +
	                           "2  - to play previous song\n" +
	                           "3  - to replay the current song\n" +
	                           "4  - list songs in the playlist\n" +
	                           "5  - to print a list of available actions\n " +
	                           "6 -  Deete current song" );
	        System.out.println("Choose your action: ");
	    }
	   
	   private static void printList(LinkedList<Songs> playList) {
	        Iterator<Songs> iterator= playList.iterator();
	        while(iterator.hasNext()) {
	            System.out.println("Now visiting " + iterator.next());
	        }
	        System.out.println("=========================");
	    }

}
