import React from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
export default class ExerciseList extends React.Component {
  //Where exercises will be stored
  state = {
    exercises: []
  }

  //Mount the API call and set state to current data
  componentDidMount() {
    axios.get(`http://localhost:8080/exercises`)
      .then(res => {
        const exercises = res.data;
        this.setState({ exercises });
      })
  }

  //Delete request using axios
  deleteRow(id, e){
    axios.delete(`http://localhost:8080/exercise/${id}`)
      .then(res => {
        console.log(res);
        console.log(res.data);
  
        const exercises = this.state.exercises.filter(item => item.id !== id);
        this.setState({ exercises });
      })

  }

  onTodoChange(event) {
    // update the state
    this.setState({name: event.target.value});
    }


  render() {
    return (
    <div>
    <h1 className='text-center'>Exercise Tracker</h1>
    <div className="container">
        <div className="row">
            <div class="col text-center">
                <button className="btn btn-primary">New Exercise</button>
            </div>
        </div>
    </div>
      <div className='customTable'>
        <table className="table">
            <thead className="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Date</th>
                    <th scope="col">Exercise</th>
                    <th scope="col">Duration</th>
                    <th scope="col">Calories Burnt</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody> 
                {
                    this.state.exercises
                    .map(exercise =>
                    <>
                    <tr>
                        <th key={exercise.id} scope="row">{exercise.id}</th>
                        <td>{exercise.date}</td>
                        <td>{exercise.name}</td>
                        <td>{exercise.duration}</td>
                        <td>{exercise.caloriesBurnt}</td>
                        <td><Link to="/form" state={{ title: "Edit Exercise", id: exercise.id, date: exercise.date, name: exercise.name, duration: exercise.duration,
                        caloriesBurnt: exercise.caloriesBurnt}}>Edit</Link>
                        <button type="button" className="btn btn-danger" onClick={(e) => this.deleteRow(exercise.id, e)}>Delete</button>
                        </td>
                    </tr>
                    </>
                    )
                }
            </tbody>
        </table>
      </div>
    </div>
    )
  }
}