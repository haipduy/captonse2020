import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {SignInComponent} from ".././body/sign-in/sign-in.component";
import {SignUpComponent} from ".././body/sign-up/sign-up.component";
import {Overlay} from "@angular/cdk/overlay";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  ngOnInit() {
  }

  constructor(public dialog: MatDialog,
              private overlay: Overlay,
  ) {}

  openDialog(type): void {
    let dialogRef ;
    const scrollStrategy = this.overlay.scrollStrategies.reposition();
    switch (type) {
      case 1: {
        dialogRef = this.dialog.open(SignInComponent, {
          width: '50%',scrollStrategy
        });
        break;
      }
      case 2: {
        dialogRef = this.dialog.open(SignUpComponent, {
          width: '50%',scrollStrategy
        });
      }
        break;
    }
    dialogRef.afterClosed().subscribe(result => {
    });
  }


}
