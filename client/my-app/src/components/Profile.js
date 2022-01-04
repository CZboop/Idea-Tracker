import ProjectList from './ProjectsList';
import IdeaList from './IdeaList';
import './Profile.css';

const Profile = ({projects, ideas}) => {
    return (
        <div className="profile-container">
            <h1>Profile</h1>
            <h2>Your Projects</h2>
            <ProjectList projects = {projects} />
            <h2>Your Ideas</h2>
            <IdeaList ideas={ideas}/>
        </div>
    )
}

export default Profile;