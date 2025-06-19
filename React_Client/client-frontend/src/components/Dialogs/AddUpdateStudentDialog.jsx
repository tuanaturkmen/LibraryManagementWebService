import React, { useState, useEffect, act } from "react";
import {
    Dialog,
    DialogTitle,
    DialogContent,
    DialogActions,
    TextField,
    Button,
} from "@mui/material";

function AddUpdateStudentDialog({ open, selectedStudent, action, handleClose, onSubmit }) {
    
    const [student, setStudent] = useState({  
        id: "",
        name: "",
        surname: "",
        department: "",
        year: "",
    });

    useEffect(() =>  {
        setStudent(selectedStudent);
    }, [selectedStudent])

    const handleChange = (e) => {
        const { name, value } = e.target;
        setStudent({ ...student, [name]: value });
    };

    const handleSubmit = () => {
        onSubmit(student);
        setStudent({
            id: "",
            title: "",
            author: "",
            publicationYear: "",
            isAvailable: false,
        });
    };

    return (
        <Dialog open={open} onClose={handleClose}>
            <DialogTitle> {action?.label} a Student</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    name="id"
                    label="ID"
                    type="number"
                    fullWidth
                    value={student.id}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="name"
                    label="Name"
                    fullWidth
                    value={student.name}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="surname"
                    label="Surname"
                    fullWidth
                    value={student.surname}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="department"
                    label="Department"
                    fullWidth
                    value={student.department}
                    onChange={handleChange}
                />
                <TextField
                    margin="dense"
                    name="year"
                    label="Year"
                    fullWidth
                    value={student.year}
                    onChange={handleChange}
                />
            </DialogContent>
            <DialogActions>
                <Button onClick={handleClose}>Cancel</Button>
                <Button onClick={handleSubmit}>{action?.label}</Button>
            </DialogActions>
        </Dialog>
  );
}

export default AddUpdateStudentDialog;
