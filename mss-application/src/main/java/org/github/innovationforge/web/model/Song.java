package org.github.innovationforge.web.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Song {
    private UUID id;
    private String title;
    private String artist;
    private String album;
    private int duration;
    private String genre;
    private String filePath;
}
