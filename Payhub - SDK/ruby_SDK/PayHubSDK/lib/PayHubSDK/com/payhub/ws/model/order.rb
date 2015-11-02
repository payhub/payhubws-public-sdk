class Order
  include JsonSerializer
  ATTRS=[:id,:invoice,:lines]
  attr_accessor *ATTRS
end