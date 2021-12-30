package com.tracker.app.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
public class IdeaController {

    private IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping("/getall")
    public List<Idea> getAllIdeas(){
        return ideaService.getAllIdeas();
    }

    @PostMapping("/add")
    public void addIdea(@RequestBody Idea idea){
        ideaService.addIdea(idea);
    }

    @PutMapping("/update")
    public void updateIdea(@RequestBody Idea idea){
        ideaService.updateIdea(idea);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIdea(@PathVariable int id){
        ideaService.deleteIdea(id);
    }

    @PostMapping("/makeproject/{id}")
    public void makeProjectFromIdeaId(@PathVariable int id){
        ideaService.makeProjectFromIdeaId(id);
    }

    @GetMapping("/getidea/{id}")
    public Idea getIdeaById(@PathVariable int id){
        return ideaService.getIdeaById(id);
    }
}
