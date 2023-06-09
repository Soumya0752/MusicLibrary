package com.example.song;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.ArrayList;
import com.example.song.SongService;
import com.example.song.Song;

@RestController 
public class SongController 
{

    SongService songService=new SongService();
    @GetMapping("/songs")
    public ArrayList<Song> getSongs()
    {
        return songService.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getsongById(@PathVariable("songId") int songId)
    {
         return songService.getsongById(songId);
    }
    
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song)
    {
        return songService.addSong(song);   
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId,@RequestBody Song song)
    {
       return songService.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId)
    {
        songService.deleteSong(songId);
    }

}
