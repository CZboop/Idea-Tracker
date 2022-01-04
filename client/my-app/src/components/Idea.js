const Idea = ({idea}) => {
    return(
        <div className="idea-container">
            <h3>{idea.summary}</h3>
            <p>{idea.details}</p>
            <p>Priority: {idea.priority}</p>
        </div>
    )

}

export default Idea;