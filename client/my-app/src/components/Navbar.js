import { Link } from "react-router-dom";
import './Navbar.css'

const Navbar = ({onLogout, token}) => {
    return (
        <nav className="nav-container">
            <ul>
            <h1>Ideas and Projects</h1>
            { token?
            <>
                <li><Link to="/profile">Profile</Link></li>
                <li><Link to="/home">Home</Link></li>
                <li onClick={() => onLogout()}><Link to="/logout">Logout</Link></li>
                <li><Link to="/register">Register</Link></li>
            </>
                :
            <>
                <li></li>
                <li><Link to="/home">Home</Link></li>
                <li><Link to="/login">Login</Link></li>
                <li><Link to="/register">Register</Link></li>
            </>

            }
            </ul>

        </nav>
    )
}

export default Navbar;