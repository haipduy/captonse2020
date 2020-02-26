import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Output("openDialog") openDialog: EventEmitter<any> = new EventEmitter();

  openSignIn(type){
    this.openDialog.emit(type);
  }
}
