import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<SignInComponent>,
    ) {}

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit():void{
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
