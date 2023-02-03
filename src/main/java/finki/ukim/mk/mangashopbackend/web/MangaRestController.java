package finki.ukim.mk.mangashopbackend.web;

import finki.ukim.mk.mangashopbackend.models.Manga;
import finki.ukim.mk.mangashopbackend.services.MangaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manga")
@AllArgsConstructor
public class MangaRestController {
    private final MangaService mangaService;

    @GetMapping
    private List<Manga> findAll(){
        return this.mangaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> findById(@PathVariable Long id){
        return this.mangaService.findById(id)
                .map(manga -> ResponseEntity.ok().body(manga))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
