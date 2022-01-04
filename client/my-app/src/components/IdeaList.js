import Idea from "./Idea";

const IdeaList = ({ideas}) => {
    const ideaComponents = ideas.map(idea => {
        return (
            <Idea idea={idea}/>
        )
    })
    return(
        <div className="idea-list-container">
            {ideaComponents}
        </div>
    )

}

export default IdeaList;