package com.example.song;
import java.util.ArrayList;
import com.example.song.Song;
public interface SongRepository 
{
    ArrayList<Song> getSongs();
    Song getsongById(int songId);
    Song addSong(Song song);

    Song updateSong(int songId,Song song);
    void deleteSong(int songId);
}