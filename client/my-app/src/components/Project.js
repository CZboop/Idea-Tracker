import TicketList from './TicketList';
import './Project.css';

const Project = ({project}) => {

    const deleteProject = (id) => {
        fetch(`http://localhost:8080/api/project/delete/${id}`, {
                    method: "DELETE",
                    
                })                
    }

    const updateProject = () => {

    }

    return (
        <div className="project-container">
            <h4>{project.title}</h4>
            <p>{project.details}</p>
            <p>Status: {project.status}</p>
            <p>Priority: {project.priority}</p>
            {project.tickets.length > 0?
            <>
            <h4>Tickets</h4>
            <TicketList tickets={project.tickets} />
            </>
            :
            <></>

            }
            <button onClick={deleteProject(project.id)}>Delete Project</button>
            <button onClick={updateProject(project.id)}>Update Project</button>
            
        </div>
    )
}

export default Project;