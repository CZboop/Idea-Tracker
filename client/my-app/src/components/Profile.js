import {useState} from 'react';
import { useEffect } from 'react/cjs/react.development';
import ProjectList from './ProjectsList';

const Profile = ({token, projects}) => {
    return (
        <div className="profile-container">
            <h1>Profile</h1>
            <h2>Your Projects</h2>
            <ProjectList projects = {projects}/>
        </div>
    )
}

export default Profile;