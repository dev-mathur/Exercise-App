import ExerciseList from './Components/ExerciseList';
import DataForm from './Components/DataForm';
import React from 'react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  useRouteMatch,
  useParams
} from "react-router-dom";
export default function App() {
  return (
    <Router>
      <div>
        <Routes>
        <Route path="/" element={<ExerciseList/>} />
        <Route path="/form" element={<DataForm/>} />
        </Routes>
      </div>
    </Router>
  );
}