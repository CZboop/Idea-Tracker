import { useState } from "react";

const Register = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        

    }

    return(
        <div className="register-container">
            <h1>Register</h1>
            <form className="register-form" onSubmit={handleSubmit}>
                <label>Username:</label><input type="text" value={username} onChange={(e) => setUsername(e.target.value)}></input>
                <label>Email:</label><input type="text" value={email} onChange={(e) => setEmail(e.target.value)}></input>
                <label>Password:</label><input type="text" value={password} onChange={(e) => setPassword(e.target.value)}></input>
                <input type="submit"/>
            </form>

        </div>
    )

}

export default Register;