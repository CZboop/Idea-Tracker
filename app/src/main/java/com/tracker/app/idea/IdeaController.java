package com.tracker.app.idea;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideas")
public class IdeaController {

    private IdeaService ideaService;

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
}
