package org.github.innovationforge.web.controller;

import lombok.RequiredArgsConstructor;
import org.github.innovationforge.web.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerResponse.BodyBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping
    public Flux<List<Song>> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Mono<Song> getSongById(@PathVariable UUID id) {
        return songService.getSongById(id);
    }

    @PostMapping
    public Mono<Song> addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @PutMapping("/{id}")
    public Mono<Song> updateSong(@PathVariable UUID id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteSong(@PathVariable UUID id) {
        return songService.deleteSong(id);
    }
//
//    @GetMapping(value = "/{id}/stream", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public Mono<byte[]> streamSongById(@PathVariable String id) throws IOException {
//        return songService.getSongFileById(id)
//                .flatMap(songFile -> {
//                    try {
//                        return Mono.just(Files.readAllBytes(songFile.toPath()));
//                    } catch (IOException e) {
//                        return Mono.error(e);
//                    }
//                });
//    }
//
//    @GetMapping(value = "/playlist/{playlistId}/stream", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public Flux<byte[]> streamSongByPlayList(@PathVariable String playlistId) throws IOException {
//        return songService.getSongFilesByPlayListId(playlistId)
//                .flatMap(songFile -> {
//                    try {
//                        return Flux.just(Files.readAllBytes(songFile.toPath()));
//                    } catch (IOException e) {
//                        return Flux.error(e);
//                    }
//                });
//    }
//
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Mono<Song> uploadSong(@RequestPart("song") Song song, @RequestPart("file") FilePart file) {
//        return songService.uploadSong(song, file);
//    }
}
