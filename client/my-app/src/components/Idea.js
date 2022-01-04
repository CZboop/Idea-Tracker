import './Idea.css';

const Idea = ({idea}) => {
    const deleteIdea = (id) => {
        fetch(`http://localhost:8080/api/ideas/delete/${id}`, {
                method: "DELETE",     
        })                
    }

    const updateIdea = (id) => {

    }

    return(
        <div className="idea-container">
            <h3>{idea.summary}</h3>
            <p>{idea.details}</p>
            <p>Priority: {idea.priority}</p>
            <button onClick={deleteIdea(idea.id)}>Delete Idea</button>
            <button onClick={updateIdea(idea.id)}>Update Idea</button>
        </div>
    )

}

export default Idea;