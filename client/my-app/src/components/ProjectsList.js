import Project from "./Project";

const ProjectList = ({projects}) => {
    const projectComponents = projects.map(project => {
        return(
            <Project project={project}/>
        )
    })
    return(
        <div className="project-list-container">
            {projectComponents}
        </div>

    )

}

export default ProjectList;