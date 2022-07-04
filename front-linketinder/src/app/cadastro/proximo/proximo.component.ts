import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-proximo',
  templateUrl: './proximo.component.html',
  styleUrls: ['./proximo.component.scss'],
})
export class ProximoComponent implements OnInit {
  candidatoId;
  constructor(private route: ActivatedRoute) {
    this.candidatoId = this.route.snapshot.paramMap.get('candidatoId');
  }

  ngOnInit(): void {}
}
