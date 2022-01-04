import {useState} from 'react';
import './Home.css';

const Home = ({token}) => {
    const [summary, setSummary] = useState("");
    const [details, setDetails] = useState("");
    const [ideaPriority, setIdeaPriority] = useState("medium");

    const handlePriorityChange = (e) => {
        setIdeaPriority(e.target.value)
    }

    const handleIdeaSubmit = () => {
        const newIdea = {
            "summary" : summary,
            "details" : details,
            "priority" : ideaPriority,
            "userId" : token.userId
        }
        fetch("http://localhost:8080/api/ideas/add", {
                    method: "POST",
                    headers: {
                        'Content-type': 'application/json'
                    },
                    body: JSON.stringify(newIdea)
                })
                // .then(response => response.json())
    }

    return (
        <div className="home-container">
            <h1>Home</h1>
            {
                token?
                <>
                <h2>Welcome</h2>

                <form className="add-idea-form" onSubmit={handleIdeaSubmit}>
                    <h3>New Idea</h3>
                    <label>Summary:</label><input type="text" value={summary} onChange={(e)=>setSummary(e.target.value)}></input>
                    <label>Details:</label><input type="text" value={details} onChange={(e)=>setDetails(e.target.value)}></input>
                    <label>Priority:</label>
                    <select value={ideaPriority} onChange={handlePriorityChange}>
                        <option value="high">High</option>
                        <option value="medium">Medium</option>
                        <option value="low">Low</option>
                    </select>
                    <input type="submit" value="Add"></input>

                </form>

                <form className="add-project-form">
                    <h3>New Project</h3>

                </form>
                </>
                :
                <>
                <h2>Create an account to use this site!</h2>
                </>
            }
        </div>

    )
}

export default Home;