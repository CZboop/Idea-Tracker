import { Link } from "react-router-dom";

const Navbar = ({onLogout}) => {
    return (
        <nav className="nav-container">
            <ul>
                <li><Link to="/profile">Profile</Link></li>
                <li><Link to="/home">Home</Link></li>
                <li><Link to="/login">Login</Link></li>
                <li onClick={() => onLogout()}><Link to="/logout">Logout</Link></li>
                <li><Link to="/register">Register</Link></li>
            </ul>

        </nav>
    )
}

export default Navbar;