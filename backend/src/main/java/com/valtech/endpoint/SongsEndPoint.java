package com.valtech.endpoint;

import com.valtech.domain.Song;
import com.valtech.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SongsEndPoint {
	@Autowired
	private SongRepository songRepository;

	@GetMapping("/songs")
	public Collection<Song> coolCars() {
		return songRepository.findAll();
	}
}
