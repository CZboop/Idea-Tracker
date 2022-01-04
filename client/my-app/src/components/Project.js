const Project = ({project}) => {
    return (
        <div className="project-container">
            <h4>{project.title}</h4>
            <p>{project.details}</p>
            <p>Status: {project.status}</p>
            <p>Priority: {project.priority}</p>
        </div>
    )
}

export default Project;