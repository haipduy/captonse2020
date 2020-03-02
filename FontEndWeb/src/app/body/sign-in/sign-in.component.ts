import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Router} from "@angular/router"

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<SignInComponent>,
    private router: Router
  ) {}

  onClose(): void {
    this.dialogRef.close();
  }

  onSubmit():void{
    this.router.navigate(['/main'])
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}
