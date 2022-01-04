import Ticket from "./Ticket";

const TicketList = ({tickets}) => {
    const ticketComponents = tickets.map(ticket => {
        return (
            <Ticket ticket={ticket}/>
        )
    })
    return(
        <div className="ticket-list-container">
            
            {ticketComponents}
        </div>
    )
}

export default TicketList;