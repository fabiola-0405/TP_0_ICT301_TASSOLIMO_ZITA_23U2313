package LSP.Violation;

import LSP.Violation.RectangleLSPv;

class Square extends RectangleLSPv {

    @Override

    public void setWidth(int width) {

        super.setWidth(width);

        super.setHeight(width);

    }

    @Override
  public void setHeight(int height) {

        super.setWidth(height);

        super.setHeight(height); }
 }