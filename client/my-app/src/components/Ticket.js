const Ticket = ({ticket}) => {
    return (
        <div className="ticket-container">
            <h4>{ticket.title}</h4>
            <p>Info: {ticket.info}</p>
            <p>Type: {ticket.type}</p>
            <p>Completed: {ticket.isCompleted}</p>
            <p>Date Created: {ticket.dateCreated}</p>
            <p>Date Completed: {ticket.dateCompleted}</p>
        </div>
    )
}

export default Ticket;