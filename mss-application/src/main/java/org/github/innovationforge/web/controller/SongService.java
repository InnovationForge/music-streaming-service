package org.github.innovationforge.web.controller;

import com.github.javafaker.Faker;
import org.github.innovationforge.web.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SongService {

    public Flux<List<Song>> getAllSongs() {
        Faker faker = new Faker();
        List<Song> songs = IntStream.range(0, 10)
                .mapToObj(i -> Song.builder()
                        .id(UUID.randomUUID())
                        .title(faker.music().chord())
                        .artist(faker.artist().name())
                        .duration(faker.number().numberBetween(120, 300))
                        .genre(faker.music().genre())
                        .album(faker.music().instrument())
                        .genre(faker.music().genre())
                        .filePath(faker.file().fileName())
                        .build())
                .collect(Collectors.toList());
        return Flux.just(songs);
    }

    public Mono<Song> getSongById(UUID id) {
        Faker faker = new Faker();
        return Mono.just(Song.builder()
                .id(id)
                .title(faker.music().chord())
                .artist(faker.artist().name())
                .duration(faker.number().numberBetween(120, 300))
                .genre(faker.music().genre())
                .album(faker.music().instrument())
                .genre(faker.music().genre())
                .filePath(faker.file().fileName())
                .build());
    }

    public Mono<Song> addSong(Song song) {
        Faker faker = new Faker();
        return Mono.just(Song.builder()
                .id(UUID.randomUUID())
                .title(faker.music().chord())
                .artist(faker.artist().name())
                .duration(faker.number().numberBetween(120, 300))
                .genre(faker.music().genre())
                .album(faker.music().instrument())
                .genre(faker.music().genre())
                .filePath(faker.file().fileName())
                .build());
    }

    public Mono<Song> updateSong(UUID id, Song song) {
        Faker faker = new Faker();
        return Mono.just(Song.builder()
                .id(id)
                .title(faker.music().chord())
                .artist(faker.artist().name())
                .duration(faker.number().numberBetween(120, 300))
                .genre(faker.music().genre())
                .album(faker.music().instrument())
                .genre(faker.music().genre())
                .filePath(faker.file().fileName())
                .build());
    }

    public Mono<Void> deleteSong(UUID id) {
        return Mono.empty();
    }
//
//    public Mono<File> getSongFileById(String id) {
//        return reactiveMongoOperations.findById(id, Song.class)
//                .map(song -> new File(song.getFilePath()));
//    }
//
//    public Flux<File> getSongFilesByPlayListId(String playlistId) {
//        return reactiveMongoOperations.find(Query.query(Criteria.where("playlists").in(playlistId)), Song.class)
//                .map(song -> new File(song.getFilePath()));
//    }
//
//    public Mono<Song> uploadSong(Song song, FilePart file) {
//        return file.transferTo(new File(song.getFilePath()))
//                .then(reactiveMongoOperations.insert(song));
//    }
}

