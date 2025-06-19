import React from "react";
import {
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  Button,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";

function ReviewDialog({ open, onClose, selectedStudent, reviews = [] }) {
  
    return (
        <Dialog open={open} onClose={onClose} fullWidth maxWidth="md">
            <DialogTitle>Reviews for {selectedStudent.name}</DialogTitle>
            <DialogContent>
                {reviews.length === 0 ? 
                    (<Typography variant="body2">No reviews found.</Typography>)
                    : 
                    (
                        <Table>
                            <TableHead>
                            <TableRow>
                                <TableCell>ID</TableCell>
                                <TableCell>Book Name</TableCell>
                                <TableCell>Rating</TableCell>
                                <TableCell>Review Text</TableCell>
                            </TableRow>
                            </TableHead>
                            <TableBody>
                            {reviews.map((review) => (
                                <TableRow key={review.id}>
                                <TableCell>{review.id}</TableCell>
                                <TableCell>{review.bookName}</TableCell>
                                <TableCell>{review.rating}</TableCell>
                                <TableCell>{review.reviewText}</TableCell>
                                </TableRow>
                            ))}
                            </TableBody>
                        </Table>
                    )
                }
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose} variant="outlined">
                    Close
                </Button>
            </DialogActions>
        </Dialog>
    )
}

export default ReviewDialog;