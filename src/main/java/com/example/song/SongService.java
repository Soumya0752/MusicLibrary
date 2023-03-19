package com.example.song; 
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniqueSongId=6;
    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    @Override 
    public ArrayList<Song> getSongs()
    {
        Collection<Song> songCollection=playlist.values();
        ArrayList<Song> songs=new ArrayList<Song>(songCollection);
        return songs;
    }

    @Override 
    public Song getsongById(int songId)
    {
        Song song=playlist.get(songId);
        if(song==null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;
    }

    @Override
    public Song addSong(Song song)
    {
       song.setsongId(uniqueSongId);  
       playlist.put(uniqueSongId,song);
       uniqueSongId=uniqueSongId+1;
       return song;           
    }

    @Override 
    public Song updateSong(int songId, Song song)
    {
     Song existingsong=playlist.get(songId);
     if(existingsong==null)
     {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);       
     }
     if(song.getsongName()!=null)
     {
        existingsong.setsongName(song.getsongName());
     }
     if(song.getlyricist()!=null)
     {
        existingsong.setlyricist(song.getlyricist());
     }
     if(song.getsinger()!=null)
     {
        existingsong.setsinger(song.getsinger());
     }
     if(song.getmusicDirector()!=null)
     {
        existingsong.setmusicDirector(song.getmusicDirector());
     }
      return existingsong;
    }
    
    @Override 
    public void deleteSong(int songId)
    {
      Song existingsong=playlist.get(songId);
      if(existingsong==null)
      {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      else 
      {
         playlist.remove(songId);
         throw new ResponseStatusException(HttpStatus.NO_CONTENT);
      }
    }
}