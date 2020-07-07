package org.peddi.javase.collections.streams.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.System.out;

public class ConvertCodeUsingAggregate {
	
	/*
	 
	 List<Album> favs = new ArrayList<>();
for (Album a : albums) {
   boolean hasFavorite = false;
   for (Track t : a.tracks) {
       if (t.rating >= 4) {
           hasFavorite = true;
           break;
       }
   }
   if (hasFavorite)
       favs.add(a);
}
Collections.sort(favs, new Comparator<Album>() {
                          public int compare(Album a1, Album a2) {
                              return a1.name.compareTo(a2.name);
                          }});

	 * 
	 */
	
	
	
	public void convertCodeUsingStreamAggregateOperations() {
		
		AlbumList al = new AlbumList();
		List<Album> albums = al.getAlbums();
		
		
		
		List<Album> favAlbums = 
		  albums.stream()
				.filter(a -> ( a.getTracks().stream().anyMatch(t -> (t.getRating() >=4 ) ) )  )
				.sorted(Comparator.comparing(Album::getName))
				.collect(Collectors.toList());
		
		out.println("\n\n Albums with Rating 4 or above");
		out.println(favAlbums);
		
		
		// Alternative solutions
		/*
		 * 
		 * Solution 1 :
		   albums.stream()
		         .filter( Album::anyMatch )
		         .sorted( (a1,a2) -> a1.getName().compareTo(a2.getName()) )
		         .collect(Collectors.toList());
		         
		 * Solution 2:      
		   albums.stream()
		         .filter( Album::anyMatch )
		         .sorted( new AlbumComparator() ))
		         .collect(Collectors.toList());      
		         
		 */
		

	}
	

	
	public static void main(String[] a) {
		ConvertCodeUsingAggregate app = new ConvertCodeUsingAggregate();
		app.convertCodeUsingStreamAggregateOperations();
	}
	
	

	/****** Helper Classes **********/
//	//implements Comparator<Album>
//	
//	public static class AlbumComparator {
//
//		//@Override
//		public static int compare(Album a1, Album a2) {
//			
//			return a1.getName().compareTo(a2.getName());	
//			
//		}	
//	}

}
