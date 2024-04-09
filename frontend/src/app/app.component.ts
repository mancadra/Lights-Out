import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { CenterSectionComponent } from './components/center-section/center-section.component';
import { LeftSidebarComponent } from './components/left-sidebar/left-sidebar.component';
import { RightSidebarComponent } from './components/right-sidebar/right-sidebar.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    CenterSectionComponent,
    LeftSidebarComponent,
    RightSidebarComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontend';
}
/*
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './components/header.component.html',
  styleUrl: './components/header.component.scss'
})

@Component({
  selector: 'app-center-section',
  standalone: true,
  imports: [CenterSectionComponent],
  templateUrl: './components/center-section.component.html',
  styleUrl: './components/center-section.component.scss'
})
@Component({
  selector: 'app-left-sidebar',
  standalone: true,
  imports: [LeftSidebarComponent],
  templateUrl: './components/left-sidebar.component.html',
  styleUrl: './components/left-sidebar.component.scss'
})
@Component({
  selector: 'app-right-sidebar',
  standalone: true,
  imports: [RightSidebarComponent],
  templateUrl: './components/right-sidebar.component.html',
  styleUrl: './components/right-sidebar.component.scss'
})*/
