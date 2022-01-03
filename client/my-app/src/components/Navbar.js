import { Link } from "react-router-dom";

const Navbar = () => {
    return (
        <nav className="nav-container">
            <ul>
                <li><Link to="/profile">Profile</Link></li>
                <li><Link to="/home">Home</Link></li>
            </ul>

        </nav>
    )
}

export default Navbar;