package spotify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.core5.http.ParseException;
import com.neovisionaries.i18n.CountryCode;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;
import song.songDTO;


public class spotifyapi {
	static createAccesstoken token=new createAccesstoken();
	private final static String accessToken=token.accesstoken();

    
    static SpotifyApi spotifyApi = new SpotifyApi.Builder().setAccessToken(accessToken).build();
    
    
    public static List<songDTO> getTrack_Sync() {
    	int i=1;
    	 try {
    		 List<songDTO> dto=new ArrayList<songDTO>();
             // Get top tracks
    		 SearchTracksRequest  searchTracksRequest = spotifyApi.searchTracks("year:2023").limit(50).market(CountryCode.KR).build();

             Paging<Track> trackPaging = searchTracksRequest.execute();

             for (Track track : trackPaging.getItems()) {
            	 songDTO dto2=new songDTO();
            	 dto2.setSname(track.getName());
            	 dto2.setSnum(i++);
<<<<<<< HEAD
            	 dto2.setPhoto(track.getAlbum().getImages()[0].getUrl());
=======
     
            	 dto2.setPhoto(track.getAlbum().getImages()[0]);
>>>>>>> 26ef665967a773824e2cada3dc70dced60211b0f
            	 dto2.setArtist(track.getArtists()[0].getName());
            	 dto.add(dto2);
             }
             return dto;
         } catch (ParseException |IOException | SpotifyWebApiException e) {
             e.printStackTrace();
         }
    	 return null;
     }
    
    public static List<songDTO> getsong(String search,CountryCode country,int count) {
    	 try {
    		 List<songDTO> dto=new ArrayList<songDTO>();
             // Get top tracks
    		 SearchTracksRequest  searchTracksRequest = spotifyApi.searchTracks(search).limit(count).market(country).build();

             Paging<Track> trackPaging = searchTracksRequest.execute();

             for (Track track : trackPaging.getItems()) {
            	 songDTO dto2=new songDTO();
            	 dto2.setSname(track.getName());
            	 dto2.setPhoto(track.getAlbum().getImages()[0].getUrl());
            	 dto2.setArtist(track.getArtists()[0].getName());
            	 dto.add(dto2);
             }
             return dto;
         } catch (ParseException |IOException | SpotifyWebApiException e) {
             e.printStackTrace();
         }
    	 return null;
     }
    public static List<songDTO> getTodaySong() {
   	 try {
   		 List<songDTO> dto=new ArrayList<songDTO>();
    

   		 SearchTracksRequest  searchTracksRequest = spotifyApi.searchTracks("year:2023").limit(10).build();

            Paging<Track> trackPaging = searchTracksRequest.execute();

            for (Track track : trackPaging.getItems()) {
           	 songDTO dto2=new songDTO();
           	 dto2.setSname(track.getName());
           	 dto2.setPhoto(track.getAlbum().getImages()[0].getUrl());
           	 dto2.setArtist(track.getArtists()[0].getName());
           	 dto.add(dto2);
            }
            return dto;
        } catch (ParseException |IOException | SpotifyWebApiException e) {
            e.printStackTrace();
        }
   	 return null;
    }
    
    }

     
     
    
 
