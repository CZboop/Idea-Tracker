package com.tracker.app.project;

import com.tracker.app.ticket.Ticket;
import com.tracker.app.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private ProjectDAO projectDAO;
    private TicketService ticketService;

    @Autowired
    public ProjectService(ProjectDAO projectDAO, TicketService ticketService) {
        this.projectDAO = projectDAO;
        this.ticketService = ticketService;
    }

    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    public List<Project> getUserProjects(int id) {
        List<Project> userProjects = projectDAO.getUserProjects(id);
        for (int i=0; i<userProjects.size(); i++){
            Project project = userProjects.get(i);
            userProjects.set(i, getProjectWithTickets(project, project.getId()));
        }
        return userProjects;
    }

    public void deleteProject(int id) {
        projectDAO.deleteProject(id);
    }

    public void updateProject(int id, Project project) {
        projectDAO.updateProject(id, project);
    }

    public Project getProjectWithTickets(Project project, Long projectId){
        List<Ticket> tickets = ticketService.getTicketsForProject(projectId);
        project.setTickets((ArrayList<Ticket>) tickets);
        return project;
    }
}
