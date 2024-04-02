import { ad_data } from "./advertisementsData.js";

export let marketplace = {

    advertisements:[],
    filterCondation:{},

    init() {
        this.advertisements = ad_data;
        this.display(this.advertisements);
    },

    display(ads) {
        let adList = '';
        ads.forEach(element => {
            let adCard = `
            <div class="card mb-4 col-md-4">
            <img class="card-img-top" src="${element.image}" alt="${element.title}">
            <div class="card-body">
              <h5 class="card-title">${element.title}</h5>
              <p class="card-text">${element.description}</p>
              <p class="card-text display-contact" role="button" data-show=0 data-contact="${element.contact}" data-toggle="tooltip" data-placement="top" title="click to show the contact">Contact: ***</p>
            </div>
            <div class="card-footer text-center">
              <button class="btn btn-info btn-block" onclick="alert('Contact: ${element.contact}')">Details</button>
            </div>
          </div>
          `
          adList += adCard;
        });
        let advertisementsNode = document.getElementById("advertisements");
        advertisementsNode.innerHTML = adList;
        this.eventsBinding();
    },

    filtering() {
       if(this.filterCondation.title == undefined || this.filterCondation.title.length == 0){
        this.display();
       }
       console.log(this.filterCondation.title);
       let ads = this.advertisements.filter(element => { return element.title == this.filterCondation.title;});
       this.display(ads);
    },
    showContact(element, val) {
        let txt = "Contact: ";
        let data = element.dataset;
        if(data.show == 0) {
            element.innerHTML = txt + data.contact;
            data.show = 1;
            element.setAttribute('title', "click to hide the contact.")
        } else {
            element.innerHTML = txt +  "***";
            data.show = 0;
            element.setAttribute('title', "click to show the contact.")
        }
    },
    showDetails() {},
    eventsBinding() {
        let filterTitleNode = document.getElementById("filterTitle");
        filterTitleNode.addEventListener('keyup', (event)=> {
            if(event.code == "Enter") {
                this.filterCondation.title = event.target.value;
                this.filtering();
            }
        })

        let displayContactNodeList = document.querySelectorAll(".display-contact");
        console.log(displayContactNodeList);
        displayContactNodeList.forEach((element) => {
            element.addEventListener('click', (e) => {
                let element = e.target;
                this.showContact(e.target);
            })
        })
    }
};