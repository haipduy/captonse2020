import { Component } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {SignInComponent} from "./body/sign-in/sign-in.component";
import {SignUpComponent} from "./body/sign-up/sign-up.component";
import {BlockScrollStrategy, Overlay} from "@angular/cdk/overlay";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'fire-detection';

  constructor(public dialog: MatDialog,
              private overlay: Overlay) {}
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

