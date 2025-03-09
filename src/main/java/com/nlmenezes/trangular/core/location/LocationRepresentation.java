package com.nlmenezes.trangular.core.location;

import com.nlmenezes.trangular.core.location.cartesian.CartesianRepresentation;
import com.nlmenezes.trangular.core.location.decimal.DecimalRepresentation;
import com.nlmenezes.trangular.core.location.dms.DMSRepresentation;

public interface LocationRepresentation {

  CartesianRepresentation toCartesianRepresentation();

  DecimalRepresentation toDecimalRepresentation();

  DMSRepresentation toDMSRepresentation();
}
