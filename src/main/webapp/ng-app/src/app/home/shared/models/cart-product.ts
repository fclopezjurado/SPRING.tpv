export class CartProduct {
	discount: number;
	amount: number;
	delivered: boolean;
	constructor(public productCode: number, public description: string, public retailPrice: number) {
		this.description = description;
		this.retailPrice = retailPrice;
		this.discount = 0;
		this.amount = 1;
		this.delivered = true;
	}	

}