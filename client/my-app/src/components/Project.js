import TicketList from './TicketList';
import './Project.css';

const Project = ({project}) => {
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
            
        </div>
    )
}

export default Project;