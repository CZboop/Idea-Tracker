import {useState} from 'react';
import './Home.css';

const Home = ({token, projects}) => {
    const [summary, setSummary] = useState("");
    const [ideaDetails, setIdeaDetails] = useState("");
    const [ideaPriority, setIdeaPriority] = useState("medium");

    const [title, setTitle] = useState("");
    const [projectDetails, setProjectDetails] = useState("");
    // using number for status as it's an enum in the backend
    const [status, setStatus] = useState(0);
    const [projectPriority, setProjectPriority] = useState("high");

    const projectOptions = projects? projects.map(project => {
        return <option value={project.id}>{project.title}</option>
    }) : null;

    const [ticketTitle, setTicketTitle] = useState("");
    const [ticketDetails, setTicketDetails] = useState("");
    const [ticketType, setTicketType] = useState(0);
    const [ticketProject, setTicketProject] = useState(null);

    const handleIdeaPriorityChange = (e) => {
        setIdeaPriority(e.target.value)
    }

    const handleProjectPriorityChange = (e) => {
        setProjectPriority(e.target.value)
    }

    const handleStatusChange = (e) => {
        setStatus(e.target.value)
    }

    const handleTicketProjectChange = (e) => {
        setTicketProject(e.target.value)
    }

    const handleTicketTypeChange = (e) => {
        setTicketType(e.target.value)
    }

    const handleIdeaSubmit = () => {
        const newIdea = {
            "summary" : summary,
            "details" : ideaDetails,
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
    }

    const handleProjectSubmit = () => {
        const newProject = {
            "title" : title,
            "details" : projectDetails,
            "priority" : projectPriority,
            "status": status,
            "userId" : token.userId,
            "tickets" : []
        }
        fetch("http://localhost:8080/api/project/add", {
                    method: "POST",
                    headers: {
                        'Content-type': 'application/json'
                    },
                    body: JSON.stringify(newProject)
                })
    }

    const handleTicketSubmit = () => {
        console.log("clicked");
        let currentdate = new Date(); 
        let datetime = "Last Sync: " + currentdate.getDate() + "/"
                + (currentdate.getMonth()+1)  + "/" 
                + currentdate.getFullYear() + " @ "  
                + currentdate.getHours() + ":"  
                + currentdate.getMinutes() + ":" 
                + currentdate.getSeconds();
        const newTicket = {
            "title" : ticketTitle,
            "info" : ticketDetails,
            "ticketType" : ticketType,
            "isCompleted" : false,
            "dateCreated": datetime,
            "dateCompleted": null
        }
        console.log(newTicket);
        fetch("http://localhost:8080/api/ticket/add", {
                    method: "POST",
                    headers: {
                        'Content-type': 'application/json'
                    },
                    body: JSON.stringify(newTicket)
                })

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
                    <label>Details:</label><textarea value={ideaDetails} onChange={(e)=>setIdeaDetails(e.target.value)}></textarea>
                    <label>Priority:</label>
                    <select value={ideaPriority} onChange={handleIdeaPriorityChange}>
                        <option value="high">High</option>
                        <option value="medium">Medium</option>
                        <option value="low">Low</option>
                    </select>
                    <input type="submit" value="Add"></input>

                </form>

                <form className="add-project-form" onSubmit={handleProjectSubmit}>
                    <h3>New Project</h3>
                    <label>Title:</label><input type="text" value={title} onChange={(e)=>setTitle(e.target.value)}></input>
                    <label>Details:</label><textarea value={projectDetails} onChange={(e)=>setProjectDetails(e.target.value)}></textarea>
                    <label>Status:</label>
                    <select value={status} onChange={handleStatusChange}>
                        <option value={0}>Active</option>
                        <option value={1}>Retired</option>
                        <option value={2}>Completed</option>
                    </select>
                    <label>Priority:</label>
                    <select value={projectPriority} onChange={handleProjectPriorityChange}>
                        <option value="high">High</option>
                        <option value="medium">Medium</option>
                        <option value="low">Low</option>
                    </select>
                    <input type="submit" value="Add"></input>
                </form>

                <form className="add-ticket-form" onSubmit={handleTicketSubmit}>
                    <h3>New Ticket</h3>
                    <label>Title:</label><input type="text" value={ticketTitle} onChange={(e)=>setTicketTitle(e.target.value)}></input>
                    <label>Details:</label><textarea value={ticketDetails} onChange={(e)=>setTicketDetails(e.target.value)}></textarea>
                    <label>Type:</label>
                    <select value={ticketType} onChange={handleTicketTypeChange}>
                        <option value={0}>To do</option>
                        <option value={1}>Bug</option>
                        <option value={2}>Note</option>
                    </select>
                    <label>Project:</label>
                    <select value={ticketProject} onChange={handleTicketProjectChange}>
                        {projectOptions}
                    </select>
                    <input type="submit" value="Add"></input>
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